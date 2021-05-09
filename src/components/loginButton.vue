<template>
    <div>
        <v-btn
                :loading="loading"
                :disabled="loading"
                color="primary"
                @click="loader = 'loading'"
                small

        >
            验证
        </v-btn>
    </div>
</template>

<script>
export default {
  name: "loginButton",
  data() {
    return{
      loader: null,
      loading: false,
    }
  },
  methods: {

  },
  watch: {
    loader () {
      const l = this.loader
      this[l] = !this[l]
      setTimeout(() => (this[l] = false), 2000)
      this.loader = null
    },
  },
}
</script>

<style scoped>
@-moz-keyframes loader {
    from {
        transform: rotate(0);
    }
    to {
        transform: rotate(360deg);
    }
}
@-webkit-keyframes loader {
    from {
        transform: rotate(0);
    }
    to {
        transform: rotate(360deg);
    }
}
@-o-keyframes loader {
    from {
        transform: rotate(0);
    }
    to {
        transform: rotate(360deg);
    }
}
@keyframes loader {
    from {
        transform: rotate(0);
    }
    to {
        transform: rotate(360deg);
    }
}
</style>