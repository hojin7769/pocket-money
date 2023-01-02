<script setup>
import excelTableColum from '../util/excel/ExcelTableColum';
import { ref } from 'vue';

const props = defineProps(['header', 'rows', 'fileName']);
const columns = ref();
(() => {
  if (String(props.fileName).match('카드')) {
    columns.value = excelTableColum.cardExcel;
  } else {
    columns.value = excelTableColum.bankExcel;
  }
})();
</script>

<template>
  <div>
    <q-table :rows="rows" :columns="columns" :title="fileName" />
  </div>
</template>
