<template>
    <div id="app">
        <v-app id="inspire">
            <v-data-table
                    :headers="headers"
                    :items="desserts"
                    sort-by="id"
                    class="elevation-1"
            >
                <template v-slot:top>
                    <v-toolbar
                            flat
                    >
                        <!--                        表头标题                        -->
                        <v-toolbar-title>用户列表</v-toolbar-title>

                        <v-divider
                                class="mx-4"
                                inset
                                vertical
                        ></v-divider>
                        <v-spacer></v-spacer>
                        <v-dialog
                                v-model="dialog"
                                max-width="500px"
                        >
                            <template v-slot:activator="{ on, attrs }">
                                <v-btn
                                        color="primary"
                                        dark
                                        class="mb-2"
                                        v-bind="attrs"
                                        v-on="on"
                                >
                                    新增
                                </v-btn>
                            </template>
                            <!--                            弹窗      -->
                            <v-card>
                                <v-card-title>
                                    <span class="headline">{{ formTitle }}</span>
                                </v-card-title>

                                <v-card-text>
                                    <v-container>
                                        <v-row>
                                            <v-col
                                                    cols="12"
                                                    sm="6"
                                                    md="4"
                                            >
                                                <v-text-field
                                                        disabled
                                                        v-model="editedItem.id"
                                                        label="id"
                                                ></v-text-field>
                                            </v-col>
                                            <v-col
                                                    cols="12"
                                                    sm="6"
                                                    md="4"
                                            >
                                                <v-text-field
                                                        v-model="editedItem.account"
                                                        label="account"
                                                ></v-text-field>
                                            </v-col>
                                            <v-col
                                                    cols="12"
                                                    sm="6"
                                                    md="4"
                                            >
                                                <v-text-field
                                                        v-model="editedItem.pwd"
                                                        label="pwd"
                                                ></v-text-field>
                                            </v-col>
                                            <v-col
                                                    cols="12"
                                                    sm="6"
                                                    md="4"
                                            >
                                                <v-text-field
                                                        v-model="editedItem.name"
                                                        label="name"
                                                ></v-text-field>
                                            </v-col>

                                        </v-row>
                                    </v-container>
                                </v-card-text>

                                <v-card-actions>
                                    <v-spacer></v-spacer>
                                    <v-btn
                                            color="blue darken-1"
                                            text
                                            @click="close"
                                    >
                                        取消
                                    </v-btn>
                                    <v-btn
                                            color="blue darken-1"
                                            text
                                            @click="save"
                                    >
                                        保存
                                    </v-btn>
                                </v-card-actions>
                            </v-card>
                        </v-dialog>
                        <v-dialog v-model="dialogDelete" max-width="500px">
                            <v-card>
                                <v-card-title class="headline">确定删除?</v-card-title>
                                <v-card-actions>
                                    <v-spacer></v-spacer>
                                    <v-btn color="blue darken-1" text @click="closeDelete">取消</v-btn>
                                    <v-btn color="blue darken-1" text @click="deleteItemConfirm">确认</v-btn>
                                    <v-spacer></v-spacer>
                                </v-card-actions>
                            </v-card>
                        </v-dialog>
                    </v-toolbar>
                </template>
                <template v-slot:item.actions="{ item }">
                    <v-icon
                            small
                            class="mr-2"
                            @click="editItem(item)"
                    >
                        mdi-pencil
                    </v-icon>
                    <v-icon
                            small
                            @click="deleteItem(item)"
                    >
                        mdi-delete
                    </v-icon>
                </template>
                <template v-slot:no-data>
                    <v-btn
                            color="primary"
                            @click="initialize"
                    >
                        Reset
                    </v-btn>
                </template>
            </v-data-table>
        </v-app>
    </div>
</template>

<script>
import axios from 'axios'
export default {
  name: "list",
  data: () => ({
    dialog: false,
    dialogDelete: false,
    headers: [
      {
        text: 'id',
        align: 'start',
        sortable: true,
        value: 'id',
      },
      { text: 'account', value: 'account' } ,
      { text: 'pwd', value: 'pwd' } ,
      { text: 'name', value: 'name' },
      { text: 'Actions', value: 'actions', sortable: false },
    ],
    desserts: [],
    editedIndex: -1,
    editedItem: {
      id: '',
      account: '',
      pwd: 0,
      name: 0,
    },
    defaultItem: {
      id: '',
      account: '',
      pwd: '',
      name: '',
    },

  }),
  computed: {
    formTitle () {
      return this.editedIndex === -1 ? '新增' : '编辑'
    },
  },
  watch: {
    dialog (val) {
      val || this.close()
    },
    dialogDelete (val) {
      val || this.closeDelete()
    },
  },
  created () {
    this.initialize()
  },
  methods: {
    initialize () {               //初始化数据
      // this.desserts = [
      //   {
      //     id: 123,
      //     pwd: '123',
      //     name: "老王",
      //   },
      // ]
      this.getLoginInfo()
    },
    getLoginInfo() {
      axios.get('http://localhost:8081/test', {
        params: {
          // id: "123"
        }
      })
          .then((res) => {
            this.desserts = res.data
          })
          .catch(function (err) {
            console.log(err);
          });
    },
    editItem (item) {
      this.editedIndex = this.desserts.indexOf(item)
      this.editedItem = Object.assign({}, item)
      this.dialog = true
    },

    deleteItem (item) {
      this.editedIndex = this.desserts.indexOf(item)
      this.editedItem = Object.assign({}, item)
      this.dialogDelete = true
    },

    deleteItemConfirm () {
      // this.desserts.splice(this.editedIndex, 1)
      axios.get('http://localhost:8081/deleteUserById', {
        params: {
          id: this.editedItem.id
        }
      })
          .then((res) => {
            this.getLoginInfo()
          })
          .catch(function (err) {
            console.log(err);
          });
      this.closeDelete()
    },

    close () {
      this.dialog = false
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem)
        this.editedIndex = -1
      })
    },

    closeDelete () {
      this.dialogDelete = false
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem)
        this.editedIndex = -1
      })
    },

    save () {
      // 修改
      if (this.editedIndex > -1) {
        axios.get('http://localhost:8081/updateUserById', {
          params: {
            account: this.editedItem.account,
            pwd: this.editedItem.pwd,
            name: this.editedItem.name,
            id: this.editedItem.id
          },
        })
            .then((res) => {
              this.getLoginInfo()
            })
            .catch(function (err) {
              console.log(err);
            });
      }
      // 新增
      else {
        axios.get('http://localhost:8081/addUser', {
          params: {
            account: this.editedItem.account,
            pwd: this.editedItem.pwd,
            name: this.editedItem.name,
          },
        })
            .then((res) => {
              this.getLoginInfo()
            })
            .catch(function (err) {
              console.log(err);
            });
      }
      this.close()
    },
  },

  components: {
  }
}
</script>

<style scoped>

</style>