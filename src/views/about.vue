<template>
    <div id="app">
        <v-app id="inspire">
            <v-card
            >
                <v-card
                        dark
                        flat
                >
                    <v-btn
                            absolute
                            bottom
                            color="pink"
                            right
                            fab
                            x-large
                            @click="like()"
                    >
                        <v-col style="padding-top: 28px"><v-icon :color="chooseColor">mdi-heart</v-icon>
                        <p>{{num}}</p>
                        </v-col>
                    </v-btn>
                    <v-img
                            max-height="450"
                            src="https://cdn.vuetifyjs.com/images/cards/forest.jpg"
                            gradient="to top, rgba(0,0,0,.44), rgba(0,0,0,.44)"
                    >
                        <v-container class="fill-height">
                            <v-col align="center">
                                <strong class="display-4 font-weight-regular mr-6">关于本站</strong>
                                <p>About  this  website</p>
                            </v-col>
                        </v-container>
                    </v-img>
                </v-card>
                <v-card-text class="py-0">
                    <v-timeline
                            align-top
                            dense
                            v-for="item in detail"
                    >
                        <v-timeline-item
                                :color="item.color"
                                small
                        >
                            <v-row class="pt-1">
                                <v-col cols="3">
                                    <strong>{{item.title}}</strong>
                                </v-col>
                                <v-col>
                                    <strong>{{item.strong}}</strong>
                                    <div class="caption">
                                        {{item.content}}
                                    </div>
                                </v-col>
                            </v-row>
                        </v-timeline-item>
                    </v-timeline>
                </v-card-text>
            </v-card>
        </v-app>
    </div>
</template>

<script>
import {mapGetters, mapState, mapMutations} from 'vuex'
import {addLikeNum, getLikeNum} from "../network/request/api";

export default {
  name: "test",
  data: () => ({
    detail: [
        {color: "pink", title: "简介 Introduce", strong: "本站创建于2021-03-11，移动端可能不太兼容，建议使用PC端~~前端用了Vue.js框架，UI方面采用了谷歌出品的Vuetify；而后端方面比较简单，只是提供了简单的留言和点赞功能的相关接口，并使用Docker容器技术将本项目部署在服务器，有关部署的相关操作可以在本人博客中查看。", content: "一名勤勤恳恳的大四学生"},
        {color: "teal lighten-3", title: "技术 Technology", strong: "技术栈", content: "vue/ vuetify/ SpringBoot/ Mysql/ Docker"},
        {color: "teal lighten-3", title: "GitHub", strong: "开源地址", content: "https://github.com/Lindon779/resume.git"},
        {color: "pink", title: "版权 Copyright", strong: "声明原创", content: "本项目全部由本人独立完成，转载或使用请标明出处"},
        {color: "teal lighten-3", title: "End", strong: "好吧，你没事就回首页去转转吧，总比在这里瞎看没营养的东西要强……", content: ""},
    ]
  }),
  methods: {
    like() {
      if(this.isClick == false){
            this.changeClick()
            addLikeNum({}).then(res =>{
                this.setNum(res)
            })
      }
    },
    ...mapMutations({
      setNum: 'setNum',
      changeClick: 'changeClick'
    })
  },
    created() {
      getLikeNum().then(res => {
          this.setNum(res)
      })
    },
    computed: {
      chooseColor() {
          if (this.isClick == false){
              return "white"
          }
          else{
              return "red"
          }
      },
        ...mapGetters({
          getNum: 'getNum'
        }),
        ...mapState({
          num: 'num',
          isClick: 'isClick'
        })
    }
}
</script>

<style scoped>

</style>