<template>
<div>
  <Header></Header>
  <Breadcrumb></Breadcrumb>
  <CardComp></CardComp>
</div>
</template>

<script>
import Header from '../components/Header.vue'
import Breadcrumb from '../components/Breadcrumb.vue'
import CardComp from '@/components/Card.vue'



export default {
  name: 'HomePage',
  components: {
    Header,
    Breadcrumb,
    CardComp,

  }
}

</script>

<style>

</style>