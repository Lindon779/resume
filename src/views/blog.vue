<template>
    <div id="app">
        <v-card>
            <v-card-title class="green--text">博客</v-card-title>
            <v-list three-line v-for="(item, index) in items.slice(5*(page-1),5*page)">
                <v-list-item :key="item.title">
                    <v-list-item-avatar>
                        <v-img :src="item.avatar"></v-img>
                    </v-list-item-avatar>

                    <v-list-item-content>
                        <a :href="item.url">
                        <v-list-item-title>{{item.title}}</v-list-item-title></a>
                        <v-list-item-subtitle>{{item.subtitle}}</v-list-item-subtitle>
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

export default {
  name: "personManage",
    data: () => ({
        page: 1,
        items: [
            {
                avatar: 'https://cdn.vuetifyjs.com/images/lists/1.jpg',
                title: 'Docker+selenium实现自动化健康报备',
                subtitle: "本文以某高校的健康报备系统为例，完成该web端的自动化操作，用到的技术栈如下所述：\n" +
                    "Docker \\ Selenium \\ Python \\ yagmail \\ ssh等",
                url: "https://blog.csdn.net/Lindons/article/details/113998170"
            },
            {
                avatar: 'https://cdn.vuetifyjs.com/images/lists/2.jpg',
                title: '服务器挂载html文件(Docker+Python)',
                subtitle: "本机系统：windows\n" +
                    "服务器系统：Ubuntu\n" +
                    "\n" +
                    "相关技术：\n" +
                    "\n" +
                    "1、git（主机用，你不会还在用自带的cmd命令行窗口吧？当然，也不是不可以）\n" +
                    "\n" +
                    "2、ssh （主机用，需要从自己的电脑把html文件上传到服务器）",
                url: "https://blog.csdn.net/Lindons/article/details/112466333"
            },
            {
                avatar: 'https://cdn.vuetifyjs.com/images/lists/3.jpg',
                title: 'python算法:删除排序链表中的重复元素',
                subtitle: '给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。',
                url: "https://blog.csdn.net/Lindons/article/details/107128243"
            },
            {
                avatar: 'https://cdn.vuetifyjs.com/images/lists/4.jpg',
                title: 'python算法：罗马数字转整数',
                subtitle: '罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。按要求将其转化为阿拉伯数字',
                url: "https://blog.csdn.net/Lindons/article/details/106124870"
            },
            {
                avatar: 'https://cdn.vuetifyjs.com/images/lists/5.jpg',
                title: '计算机网络：计算路由表下一跳',
                subtitle: '共收到5个分组，其目的站IP地址分别为\n' +
                    '(1)128.96.39.10\n' +
                    '(2)128.96.40.12\n' +
                    '(3)128.96.40.151',
                url: "https://blog.csdn.net/Lindons/article/details/105810418"
            }
        ]
  }),
  computed: {
      pageNum() {
          return parseInt((this.items.length)/5)
      }
  },

  methods: {

  }
}
</script>

<style scoped>

</style>