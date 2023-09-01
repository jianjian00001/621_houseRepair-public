import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import fangwuxinxi from '@/views/modules/fangwuxinxi/list'
    import weixiushenbaodan from '@/views/modules/weixiushenbaodan/list'
    import yezhu from '@/views/modules/yezhu/list'
    import weixiudanwei from '@/views/modules/weixiudanwei/list'
    import fangwuweihu from '@/views/modules/fangwuweihu/list'
    import weixiuwancheng from '@/views/modules/weixiuwancheng/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/fangwuxinxi',
        name: '房屋信息',
        component: fangwuxinxi
      }
      ,{
	path: '/weixiushenbaodan',
        name: '维修申报单',
        component: weixiushenbaodan
      }
      ,{
	path: '/yezhu',
        name: '业主',
        component: yezhu
      }
      ,{
	path: '/weixiudanwei',
        name: '维修单位',
        component: weixiudanwei
      }
      ,{
	path: '/fangwuweihu',
        name: '房屋维护',
        component: fangwuweihu
      }
      ,{
	path: '/weixiuwancheng',
        name: '维修完成',
        component: weixiuwancheng
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
