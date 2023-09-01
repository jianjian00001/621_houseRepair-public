<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="80px"
	  style="background: transparent;"
    >  
     <el-row>
      <el-col :span="12">
        <el-form-item   v-if="flag=='yezhu'"  label="业主号" prop="yezhuhao">
          <el-input v-model="ruleForm.yezhuhao" readonly              placeholder="业主号" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='yezhu'"  label="业主姓名" prop="yezhuxingming">
          <el-input v-model="ruleForm.yezhuxingming"               placeholder="业主姓名" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item v-if="flag=='yezhu'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in yezhuxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='yezhu'"  label="业主手机" prop="yezhushouji">
          <el-input v-model="ruleForm.yezhushouji"               placeholder="业主手机" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='yezhu'"  label="身份证" prop="shenfenzheng">
          <el-input v-model="ruleForm.shenfenzheng"               placeholder="身份证" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='yezhu'"  label="楼房号" prop="loufanghao">
          <el-input v-model="ruleForm.loufanghao"               placeholder="楼房号" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='yezhu'"  label="车牌号" prop="chepaihao">
          <el-input v-model="ruleForm.chepaihao"               placeholder="车牌号" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='weixiudanwei'"  label="维修工号" prop="weixiugonghao">
          <el-input v-model="ruleForm.weixiugonghao" readonly              placeholder="维修工号" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='weixiudanwei'"  label="师傅姓名" prop="shifuxingming">
          <el-input v-model="ruleForm.shifuxingming"               placeholder="师傅姓名" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item v-if="flag=='weixiudanwei'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in weixiudanweixingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='weixiudanwei'"  label="年龄" prop="nianling">
          <el-input v-model="ruleForm.nianling"               placeholder="年龄" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='weixiudanwei'"  label="师傅手机" prop="shifushouji">
          <el-input v-model="ruleForm.shifushouji"               placeholder="师傅手机" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-form-item v-if="flag=='users'" label="用户名" prop="username">
        <el-input v-model="ruleForm.username" 
        placeholder="用户名"></el-input>
      </el-form-item>
      <el-col :span="24">
      <el-form-item>
        <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
      </el-form-item>
      </el-col>
      </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
      yezhuxingbieOptions: [],
      weixiudanweixingbieOptions: [],
    };
  },
  mounted() {
    var table = this.$storage.get("sessionTable");
    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
    this.yezhuxingbieOptions = "男,女".split(',')
    this.weixiudanweixingbieOptions = "男,女".split(',')
  },
  methods: {
    onUpdateHandler() {
      if((!this.ruleForm.yezhuhao)&& 'yezhu'==this.flag){
        this.$message.error('业主号不能为空');
        return
      }
      if((!this.ruleForm.mima)&& 'yezhu'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
      if( 'yezhu' ==this.flag && this.ruleForm.yezhushouji&&(!isMobile(this.ruleForm.yezhushouji))){
        this.$message.error(`业主手机应输入手机格式`);
        return
      }
      if( 'yezhu' ==this.flag && this.ruleForm.shenfenzheng&&(!checkIdCard(this.ruleForm.shenfenzheng))){
        this.$message.error(`身份证应输入身份证格式`);
        return
      }
      if((!this.ruleForm.weixiugonghao)&& 'weixiudanwei'==this.flag){
        this.$message.error('维修工号不能为空');
        return
      }
      if((!this.ruleForm.mima)&& 'weixiudanwei'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
      if( 'weixiudanwei' ==this.flag && this.ruleForm.shifushouji&&(!isMobile(this.ruleForm.shifushouji))){
        this.$message.error(`师傅手机应输入手机格式`);
        return
      }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
	this.$message.error(`用户名不能为空`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
