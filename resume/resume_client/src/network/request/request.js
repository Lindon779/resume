import axios from 'axios'
import QS from 'qs'
// export function request(config,success,fail) {
  // 方法一：
  // axios({
  //   url: config
  // }).then(res=>{
  //   success(res);
  // }).catch(err=>{
  //   fail(err);
  // })

  // 方法二：
  // axios.defaults.baseURL="http://cloudcottage.cn";
  // axios(config.url).then(
  //     res=>{
  //       config.success(res);
  //     }
  // ).catch(err=>{
  //   config.fail(err);
  // })

  // // 方法三：
  // let newVar = axios.create({
  //   baseURL:"http://cloudcottage.cn",
  //   timeout: 5000
  // });
  // return newVar(config);
// }
axios.defaults.baseURL= 'http://cloudcottage.cn:8088'
// Get请求
export function get(url, params){
  return new Promise((resolve, reject) =>{
    axios.get(url, {
      params: params
    }).then(res => {
      resolve(res.data);
    }).catch(err =>{
      reject(err.data)
    })
  });}

  // Post请求
export function post(url, params) {
  return new Promise((resolve, reject) => {
    axios.post(url, params)
        .then(res => {
          resolve(res.data);
        })
        .catch(err =>{
          reject(err.data)
        })
  });
}