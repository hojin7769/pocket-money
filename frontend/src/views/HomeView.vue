<script setup>
import { ref } from 'vue';
import * as XLSX from 'xlsx';

const model = ref();
const header = ref([]);
const row = ref([]);

function readExcel(value) {
  console.log(value);
  const workbook = XLSX.readFile(
    'C:\\새 폴더\\신용카드이용내역_승인_국내통합.xlsx',
  );

  const sheet = workbook.Sheets[workbook.SheetNames[0]];

  const row = sheet[XLSX.utils.encode_cell({ r: 0, c: 0 })];
  if (row) {
    // 헤더 셀 수
    const cellCount = Object.keys(sheet).length / Object.keys(row).length;

    for (let i = 0; i < cellCount; i++) {
      const cell = sheet[XLSX.utils.encode_cell({ r: 0, c: i })];
      if (cell) {
        const value = cell.v;
        header.value.push(value);
      }
    }
  }
}

function readTextFile(tt) {
  const file = tt;
  const reader = new FileReader();
  reader.onload = () => {
    const data = reader.result;
    const workBook = XLSX.read(data, { type: 'binary' });
    //workBook.SheetNames : 엑셀파일의 시트이름이 배열로 담김
    workBook.SheetNames.forEach(sheetName => {
      //row : 엑셀의 한 행이 json으로 추출됨
      row.value = XLSX.utils.sheet_to_json(workBook.Sheets[sheetName]);
      console.log(row.value);
      header.value.push(Object.keys(row.value[0]));
    });
  };
  reader.readAsBinaryString(file);
}
</script>

<template>
  <q-page>
    <div class="q-pa-md" style="max-width: 300px">
      <div class="q-gutter-md">
        <q-file
          v-model="model"
          label="Standard"
          @update:model-value="readTextFile"
        />
      </div>
      {{ header }}
    </div>
  </q-page>
</template>
