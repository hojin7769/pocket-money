<script setup>
import { ref } from 'vue';
import * as XLSX from 'xlsx';

const model = ref();
const header = ref([]);
const row = ref([]);
function readExcel(value){
  const reader = new FileReader();
  reader.onload = function () {
    let data = reader.result
    let workBook = XLSX.read(data,{type:'binary'});

    workBook.SheetNames.forEach(function (sheetName){
      console.log('SheetName: ' + sheetName );
      let rows = XLSX.utils.sheet_to_json(workBook.Sheets[sheetName]);
      console.log(JSON.stringify(rows));
    })
  }
  reader.readAsBinaryString(value);
}
</script>

<template>
  <q-page>
    <div class="q-pa-md" style="max-width: 300px">
      <div class="q-gutter-md">
        <q-file
            v-model="model"
            label="Standard"
            @update:model-value="readExcel"
        />
      </div>
    </div>
  </q-page>
</template>
