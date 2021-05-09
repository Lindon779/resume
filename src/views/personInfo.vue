<template>
    <div id="app">
        <v-app id="inspire">
            <h2 class="green--text" style="padding: 16px">【基本信息】</h2>
            <v-form>
                <v-container>
                    <v-row style="display: flex; justify-content: center">
                        <v-col
                                cols="5"
                                sm="4"
                                v-for="(info, index) in infos"
                        >
                            <v-text-field
                                    :value="info.value"
                                    :label="info.label"
                                    readonly
                                    color="green"
                            ></v-text-field>
                            <v-col cols="5"></v-col>
                        </v-col>
                    </v-row>
                    <v-dialog v-model="dia" onclick="wechat()" max-width="400px">
                        <template v-slot:activator="{ on, attrs }">
                            <v-btn
                                    color="cyan"
                                    dark
                                    v-bind="attrs"
                                    v-on="on"
                                    fab
                                    style="float: right"
                            >
                                <v-icon dark>
                                    mdi-wechat
                                </v-icon>
                            </v-btn>
                        </template>
                        <v-img src="../../public/img/wechat2.jpg">
                        </v-img>
                    </v-dialog>
                </v-container>
            </v-form>
            <h2 class="green--text" style="padding: 16px">【实习经历】</h2>
            <v-card>
                <v-row style="display: flex; justify-content: space-around">
                    <v-col sm="8" class="subheading">声希科技有限公司</v-col>
                    <v-col sm="3" style="font-size: small">2020-12-25-至今</v-col>
                </v-row>
                <v-row style="padding-left: 30px">
                    <v-row>
                        <v-card-item class="subheading">
                            职位: 软件测试实习生
                        </v-card-item>
                    </v-row>
                    <v-row>
                        <v-card-item class="subheading">
                            对该公司所研发的App以及内部的CRM后台管理系统进行相关功能测试用例设计、执行，针对相关问题与公司的相关开发人员、产品专员进行及时的沟通和反馈，确保公司的产品顺利上线对该公司所研发的App以及内部的CRM后台管理系统进行相关功能测试用例设计、执行，针对相关问题与公司的相关开发人员、产品专员进行及时的沟通和反馈，确保公司的产品顺利上线
                        </v-card-item>
                    </v-row>
                </v-row>
            </v-card>
        </v-app>
    </div>
</template>

<script>
import axios from 'axios'
export default {
  name: "personInfo",
  data: () =>({
    dia: false,
    infos: [
        {label: "姓名", value: "Lindon"},
        {label: "出生年月", value: "1999-02"},
        {label: "籍贯", value: "广东-佛山"},
        {label: "政治面貌", value: "共青团员"},
        {label: "毕业院校", value: "佛山科学技术学院"},
        {label: "专业", value: "计算机科学与技术"},
        {label: "学历", value: "本科"},
        {label: "电话", value: "13058306883"},

    ]
  }),
  methods: {
    wechat() {
        this.dia = !this.dia
    }
  },
  created() {

  },
  computed: {

  }
}
</script>

<style scoped>

</style>