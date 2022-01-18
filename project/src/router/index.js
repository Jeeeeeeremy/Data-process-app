import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter)
const routes = [
  {
  path: '/',
  name: 'index',
  component:()=>import('../views/index/index.vue'),
	meta:{
	title:'首页'
	}
  }
]
const router = new VueRouter({
    routes
  })

/*路由前置守卫*/
router.beforeEach((to,from,next)=>{
    /*修改头部标题信息*/
    if(to.meta.title){
      document.title = to.meta.title   
    }else{
      document.title = ''
    }
    next();  
})
export default router
