import Vue from 'vue'
import App from './App.vue'
// import './registerServiceWorker'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'
Vue.config.productionTip = false

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')

// router.beforeEach((to, from, next) => {
//   if (to.path != "/login" && localStorage.islogin == "false"){
//       next({path: '/login'})
//       alert("非法登录！！！")
//     }
//   else if (to.path == "/login" && localStorage.isLogin == "true"){
//     next({path: '/home'})
//   }
//     else {
//       next()
//     }
// })
// axios调用者位置
import axios from 'axios'
import {request} from "@/network/request/request";
// var url = store.getters.getUrl
// axios.get('http://' + url + '/test', {  //params参数必写 , 如果没有参数传{}也可以
//   params: {
//
// }
// })
//     .then(function (res) {
//       console.log(res.data);
//     })
//     .catch(function (err) {
//       console.log(err);
//     });

// 调用方式三：
// request({
//   url: '/test'
// }).then(res=>{
//   // console.log("打印结果+++++++++" + res.data);
// })