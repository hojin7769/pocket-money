<script setup>
import { ref } from 'vue';
import * as XLSX from 'xlsx';
import ExcelViewTable from '../components/ExcelViewTable.vue';
import axios from 'axios';
import check from '../util/excel/Check';

const model = ref();
const header = ref([]);
const row = ref([]);
const paramData = ref([]);

const fileName = ref();

const nameCheck = value => {
  fileName.value = check.nameCheck(value.name);
  alert(fileName.value)
  switch (check.nameCheck(value.name)) {
    case '카드':
      readExcel(value, updateCardDB);
      break;
    case '은행':
      readExcel(value, console.consolePrint,{
        header: 0,
        range: 6,
        defval: '',
      });
      break;
  }
};
function readExcel(value, callbackFn,option) {
  console.log(value);
  const reader = new FileReader();
  reader.onload = function () {
    let data = reader.result;
    let workBook = XLSX.read(data, { type: 'binary' });

    workBook.SheetNames.forEach(sheetName => {
      let rows = XLSX.utils.sheet_to_json(workBook.Sheets[sheetName]);

      header.value = Object.keys(rows[0]);
      row.value = rows;

      callbackFn(rows);
    });
  };
  reader.readAsBinaryString(value);
}
function updateCardDB(rowData) {
  rowData.map(row => {
    const data = {
      approvalNumber: row.승인번호,
      identification: row.본인구분,
      brand: row.브랜드,
      card: row.이용카드,
      merchantName: row.가맹점명,
      amount: row.이용금액,
      classification: row.이용구분,
      purchaseStatus: row.매입상태,
      useDate: row.이용일시,
    };
    paramData.value.push(data);
  });
  // axios
  //   .post('/api/card/saveAll', paramData.value)
  //   .then(res => {
  //     console.log(res);
  //   })
  //   .catch(err => {
  //     console.log(err);
  //   });
}
</script>

<template>
  <div>
    <div class="q-pa-md" style="max-width: 300px">
      <div class="q-gutter-md">
        <q-file
          v-model="model"
          label="Standard"
          @update:model-value="nameCheck"
        />
      </div>
    </div>
    <div>
      <ExcelViewTable
        :header="header"
        :rows="row"
        :fileName="fileName"
      ></ExcelViewTable>
    </div>
  </div>
</template>
