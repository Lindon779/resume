<template>
<div id="app">

    <v-card>
        <v-card-title class="green--text">【专业技能】</v-card-title>
        <v-row v-for="item in skills" style="padding: 15px" >
            <v-col style="padding: 10px; font-size: large" ><v-icon color="cyan">{{item.icon}}</v-icon>{{item.content}}</v-col>
        </v-row>
    </v-card>

    <v-card min-height="200px">
        <v-card-title class="green--text">【技能证书】</v-card-title>
        <v-row style="display: flex; justify-content: space-around; padding-top: 30px">
            <v-btn sm="4" rounded color="primary" dark>英语四级 CET-4</v-btn>
            <v-btn sm="4" rounded color="error" dark>软考中级 软件设计师</v-btn>
            <v-btn sm="4" rounded color="warning" dark>计算机等级 二级</v-btn>
        </v-row>
    </v-card>
</div>
</template>

<script>
export default {
  name: "message",
  data(){
    return{
        skills: [
            {icon: "mdi-numeric-1-circle", content: "熟练使用Fiddler进行抓包，拦截修改请求，弱网模拟等"},
            {icon: "mdi-numeric-2-circle", content: "熟悉常用的测试用例设计方法，个人习惯使用xind思维导图进行设计"},
            {icon: "mdi-numeric-3-circle", content: "能使用Jmeter进行基本的性能测试"},
            {icon: "mdi-numeric-4-circle", content: "掌握Selenium的基本使用"},
            {icon: "mdi-numeric-5-circle", content: "掌握vue.js的基本使用"},
            {icon: "mdi-numeric-6-circle", content: "能用SpringBoot进行简单的数据接口开发"},
            {icon: "mdi-numeric-7-circle", content: "熟悉常用的sql命令，个人习惯用mysql"},
            {icon: "mdi-numeric-8-circle", content: "掌握Docker的基本使用，本人所有项目的部署一般都是使用Docker"},
            {icon: "mdi-numeric-9-circle", content: "人生苦短，我用Python"},
        ]
    }
  },
  created() {

  },
  methods: {

  },
}
</script>

<style scoped>

</style>