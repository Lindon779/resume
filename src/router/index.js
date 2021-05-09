import Vue from 'vue'
import VueRouter from 'vue-router'
const home = () => import('../views/home.vue')
const about = () => import('../views/about.vue')
const skill = () => import('../views/skill.vue')
const personInfo = () => import('../views/personInfo.vue')
const blog = () => import('../views/blog.vue')

Vue.use(VueRouter)
const routes = [
  {
    path: '',
    redirect: '/home'
  },
  {
    path: '/home',
    component: home
  },
  {
    path: '/about',
    component: about
  },
  {
    path: '/skill',
    component: skill
  },
  {
    path: '/personInfo',
    component: personInfo
  },
  {
    path: '/blog',
    component: blog
  },
]

const router = new VueRouter({
  routes,
})

// router.beforeEach((to, from, next) => {
  // let isLogin = store.state.isLogin
  // console.log(isLogin)
  // if (isLogin == false){
  //   next({name: "login"})
  // }
  // else {
  //   next()
  // }
// })
export default router
