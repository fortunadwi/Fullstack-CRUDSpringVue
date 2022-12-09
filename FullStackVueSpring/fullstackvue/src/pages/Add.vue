<template>
<div>
  <Header></Header>
  <TableAdd></TableAdd>
  <Copyright></Copyright>
</div>
</template>

<script>
import Copyright from '@/components/Copyright.vue'
import Header from '../components/Header.vue'
import TableAdd from '../components/TableAdd.vue'

export default {
  name: 'AddPage',
  components: {
    Header,
    TableAdd,
    Copyright,

  }
}
</script>

<style>

</style>