<template>
  <div id="app">
    <v-app>
      <Navbar></Navbar>
      <v-main style="padding-top: 10px">
        <router-view></router-view>
      </v-main>
    </v-app>
  </div>
</template>

<script>
import Navbar from "./components/Navbar"
export default {
  name: 'App',
  components: {
    Navbar,
  },

  data: () => ({
  }),
};
</script>
