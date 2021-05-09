<template>
    <div>
    <v-carousel
        cycle
        height="300"
        hide-delimiter-background
        show-arrows-on-hover
    >
        <v-carousel-item
            v-for="(slide, i) in slides"
            :key="i"
            :href=url[i]
        >
                <v-sheet
                :color="colors[i]"
                height="100%"
            >
                <v-row
                    class="fill-height"
                    align="center"
                    justify="center"
                >
                    <div class="display-3">
                        {{ slide }}
                    </div>
                </v-row>
                </v-sheet>
        </v-carousel-item>
    </v-carousel>
        <v-card>
            <AddDialog sm="2" style="float: right;padding-right: 30px" v-on:addMission="init()"></AddDialog>
            <v-card-title sm="10" class="green--text">留言板</v-card-title>
            <v-list three-line v-for="(item, index) in items.slice(3*(page-1),3*page)">
                <v-list-item :key="index">
                    <v-list-item-avatar>
                        <v-img :src="item.url"></v-img>
                    </v-list-item-avatar>

                    <v-list-item-content>
                        <v-row>
                            <v-col sm="8">{{item.name}}</v-col>
                            <v-col sm="3" style="font-size: small">{{item.time}}</v-col>
                        </v-row>
                        <v-list-item-subtitle>{{item.content}}</v-list-item-subtitle>
                    </v-list-item-content>
                </v-list-item>
            </v-list>
        </v-card>
        <v-pagination
                v-model="page"
                :length=pageNum
                circle
        ></v-pagination>
    </div>
</template>

<script>
import {getMessage} from '../network/request/api'
import Popup from "@/components/Popup";
import AddDialog from "../components/AddDialog";
export default {
  name: "home",
  components: {
      Popup,
      AddDialog
  },
  data() {
    return {
        page: 1,
        colors: [
            'indigo',
            'warning',
            'pink darken-2',
            'red lighten-1',
            'deep-purple accent-4',
        ],
        slides: [
            'Docker+selenium实现自动化健康报备',
            '服务器挂载html文件(Docker+Python)',
            'python算法:删除排序链表中的重复元素',
            '计算机网络：计算路由表下一跳',
            'python算法：罗马数字转整数',
        ],
        items: [
            {
                url: 'https://cdn.vuetifyjs.com/images/lists/1.jpg',
                name: 'Brunch this weekend?',
                content: "I'll be in your neighborhood doing errands this weekend. Do you want to hang out?",
                time: "2021-03-14 10:00:00"
            },
        ],
        url:["https://blog.csdn.net/Lindons/article/details/113998170",
          "https://blog.csdn.net/Lindons/article/details/112466333",
          "https://blog.csdn.net/Lindons/article/details/107128243",
          "https://blog.csdn.net/Lindons/article/details/105810418",
          "https://blog.csdn.net/Lindons/article/details/106124870"
        ]
    }
    },


  created() {
      this.init()
  },
  methods: {
      init(){
          getMessage().then(res =>{
              this.items = res.data
          })
      },
    toPage(i){

    }
  },
  computed: {
      pageNum() {
          return parseInt((this.items.length)/3)
      }
  }
  }
</script>

<style scoped>

</style>