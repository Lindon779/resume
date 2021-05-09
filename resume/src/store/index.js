import Vue from 'vue'
import Vuex from 'vuex'


Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    num: 0,
    isClick: false
  },
  getters:{
    getNum:(state, getters) => {
      return getters.getNum
    }
  }
  ,
  mutations: {
    setNum(state, num){
      state.num = num
    },
    changeClick(state){
      state.isClick = true
    }

  },
  actions: {
  },
  modules: {
  }
})
