<template>
    <div class="text-center">
        <v-dialog max-width="600px" v-model="dialog">
            <template v-slot:activator="{ on, attrs }">
                <v-btn text class="mx-2" small
                       fab
                       dark
                       color="cyan"
                       v-bind="attrs"
                       v-on="on">
                    <v-icon dark>
                        mdi-plus
                    </v-icon>
                </v-btn>
            </template>
            <v-card>
                <v-card-title>
                    <h3>说点什么吧~~</h3>
                </v-card-title>

                <v-card-text>
                    <v-form class="px-3">
                        <v-text-field label="标题" v-model="title" prepend-icon="mdi-folder"></v-text-field>
                        <v-textarea label="内容"  v-model="content" prepend-icon="mdi-lead-pencil"></v-textarea>

                            <v-dialog
                                    v-model="dialog2"
                                    persistent
                                    max-width="290"
                            >
                                <template v-slot:activator="{ on, attrs }">
                                    <v-btn
                                            color="primary"
                                            dark
                                            v-bind="attrs"
                                            v-on="on"
                                            @click="submit"
                                    >
                                        发表
                                    </v-btn>
                                </template>
                                <v-card>
                                    <v-card-title class="headline">
                                        发表成功！
                                    </v-card-title>
                                    <v-icon color="green" x-large>mdi-check</v-icon>
                                    <v-card-actions>
                                        <v-spacer></v-spacer>
                                        <v-btn
                                                color="green darken-1"
                                                text
                                                @click="submit2"
                                        >
                                            确定
                                        </v-btn>

                                    </v-card-actions>
                                </v-card>
                            </v-dialog>
<!--                        <v-col><v-btn color="primary" dark @click="dialog = !dialog">取消</v-btn></v-col>-->
<!--                            <v-col><v-btn color="primary"-->
<!--                                          dark @click="dialog = !dialog">取消</v-btn></v-col>-->

                    </v-form>
                </v-card-text>

            </v-card>
        </v-dialog>
    </div>
</template>

<script>
import axios from 'axios'
export default {
  name: "Popup",
  data() {
    return {
      dialog: false,
      dialog2: false,
      title: '',
      content: '',
    }
  },
  methods: {
    submit() {
      axios.get('http://cloudcottage.cn/setAnnouncement', {  //params参数必写 , 如果没有参数传{}也可以
        params: {
          title: this.title,
          content: this.content,
          userId: window.localStorage.getItem('currId'),
        }
      })
          .then(function (res) {
            console.log(res.data);
          })
          .catch(function (err) {
            console.log(err);
          });
      // this.dialog = false
    },
    submit2() {
      this.dialog2 = false
      this.dialog = false
      this.$emit("submitSuccess")
      this.title = ''
      this.content = ''
    }
  }
}
</script>

<style scoped>

</style>