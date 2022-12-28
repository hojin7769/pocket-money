<script setup>
import excelTableColum from '../util/excel/ExcelTableColum';
import { ref } from 'vue';

const porps = defineProps(['header', 'rows', 'fileName']);
const columns = ref(
  porps.fileName === '카드'
    ? excelTableColum.cardExcel
    : excelTableColum.banckExcel,
);
</script>

<template>
  <div>
    <q-table :rows="rows" :columns="columns" title="카드 내역" />
  </div>
</template>
