<template>
            <v-row>
                <v-dialog
                        v-model="dialog"

                        max-width="400px"
                >
                    <template v-slot:activator="{ on, attrs }">
                        <v-btn
                                color="cyan"
                                dark
                                v-bind="attrs"
                                v-on="on"
                                fab
                        >
                            <v-icon dark>
                                mdi-pencil
                            </v-icon>
                        </v-btn>
                    </template>
                    <v-card>
                        <v-card-title>
                            <span class="headline">写留言</span>
                        </v-card-title>
                        <v-card-text>
                            <v-text-field
                                    label="留下你的名字~"
                                    v-model="name"
                            ></v-text-field>
                                <v-text-field
                                    label="随便说点什么吧~"
                                    required
                                    v-model="mission"
                                ></v-text-field>
                            <v-radio-group v-model="radioGroup">
                                <strong>选择一张图片作为头像吧~</strong>
                                <v-row>
                                    <v-col v-for="n in url" :key="n" :value="n">
                                        <v-radio ></v-radio>
                                    <v-avatar><img :src=n alt=""></v-avatar>
                                    </v-col>
                                </v-row>
                            </v-radio-group>
                        </v-card-text>
                        <v-card-actions>
                            <v-spacer></v-spacer>
                            <v-btn
                                    color="blue darken-1"
                                    text
                                    @click="dialog = false"
                            >
                                取消
                            </v-btn>
                            <v-btn
                                    color="blue darken-1"
                                    text
                                    @click="addMission()"
                            >
                                提交
                            </v-btn>
                        </v-card-actions>
                    </v-card>
                </v-dialog>
            </v-row>
</template>

<script>
  import {addMessage} from "../network/request/api";
  export default {
  name: "AddDialog",
  data: () => ({
    dialog: false,
    mission: '',
    name: '一名路过的小学生',
    radioGroup: 0,
    url: ["https://cdn.vuetifyjs.com/images/lists/1.jpg",
    "https://cdn.vuetifyjs.com/images/lists/2.jpg",
    "https://cdn.vuetifyjs.com/images/lists/3.jpg",
    "https://cdn.vuetifyjs.com/images/lists/4.jpg",
    "https://cdn.vuetifyjs.com/images/lists/5.jpg"]
  }),
  methods: {
    addMission(){
      this.dialog = false
      addMessage({name: this.name, content: this.mission, url: this.url[this.radioGroup]}).then(res =>{
          this.$emit("addMission", this.mission)
      }).catch(err =>{
          console.log(err);
      })

    }
  }
}
</script>

<style scoped>

</style>