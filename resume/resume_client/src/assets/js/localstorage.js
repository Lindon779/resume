export function localStorageGetIsLogin(){
  let result = false
  try {
    result = JSON.parse(window.localStorage.getItem('islogin'))
  } catch (e){
    return false
  }
  return result
}
export function localStorageGetCurrId() {
  let result = null
  try {
    result = JSON.parse(window.localStorage.getItem('currId'))
  } catch (e) {
    return null
    return result
  }
}

export function localStorageSetIsLogin(value){
  window.localStorage.setItem('islogin', value)
}
export function localStorageSetCurrId(value){
  window.localStorage.setItem('currId', value)
}
export function localStorageSetCurrAccount(value){
  window.localStorage.setItem('currAccount', value)
}
export function localStorageSetUserName(value){
  window.localStorage.setItem('userName', value)
}
