<template>
    <nav>
        <v-toolbar flat>
            <v-app-bar app flat>
                <v-toolbar-title class="text-uppercase green--text">
                    <span class="font-weight-light">YES!</span>
                </v-toolbar-title>

                <v-spacer></v-spacer>
                <div>
                    <v-btn text color="green" type="primary" @click="screen">
                        <span>全屏</span>
                        <v-icon v-if="isFullscreen == false" left class="ml-1">mdi-fullscreen</v-icon>
                        <v-icon v-else left class="ml-1">mdi-fullscreen-exit</v-icon>
                    </v-btn>
                </div>
            </v-app-bar>
        </v-toolbar>

        <v-navigation-drawer app permanent expand-on-hover class="teal lighten-2">
<!--            <v-layout column align-center>-->
<!--                <v-flex class="mt-5">-->
<!--                    <v-avatar size="100">-->
<!--                        <img src="../../public/head.jpg" alt="">-->
<!--                    </v-avatar>-->
<!--                    <p class="white&#45;&#45;text subheading mt-1 text-center">{{userName}}</p>-->
<!--                </v-flex>-->
<!--            </v-layout>-->
            <v-list>
                <v-list-item class="px-2" align-center>
                    <v-list-item-avatar>
                        <v-img src="../../public/head.jpg"></v-img>
                    </v-list-item-avatar>
                </v-list-item>
                <v-list-item link>
                    <v-list-item-content class="white--text">
                        <v-list-item-title class="title">
                            {{userName}}
                        </v-list-item-title>
                        <v-list-item-subtitle>{{mail}}</v-list-item-subtitle>
                    </v-list-item-content>
                </v-list-item>
                <v-list-item v-for="link in links" :key="link.text" :to="link.route">
                    <v-list-item-action>
                        <v-icon class="white--text">{{link.icon}}</v-icon>
                    </v-list-item-action>
                    <v-list-item-title class="white--text">{{link.text}}</v-list-item-title>
                </v-list-item>
            </v-list>

        </v-navigation-drawer>
    </nav>
</template>

<script>
import screenfull from 'screenfull'
export default {
  name: "Navbar",
  components: {

  },
  data() {
    return {
      userName: "叶健勇",
      mail: "yes.jy@qq.com",
      isFullscreen: false,
      links: [
        {icon: 'mdi-home-outline', text: '首页', route: '/home'},
        {icon: 'mdi-account-details', text: '个人信息', route: '/personInfo'},
        {icon: 'mdi-ansible', text: '专业技能', route: '/skill'},
        {icon: 'mdi-blogger', text: '博客', route: '/blog'},
        {icon: 'mdi-information-variant', text: '关于', route: '/about'},
      ]
    }
  },
  methods: {
    screen() {
      screenfull.toggle();
      this.isFullscreen = !this.isFullscreen
    },
  },
  computed: {
  }

}
</script>

<style scoped>

</style>