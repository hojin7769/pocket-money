<script setup>
import { onMounted, ref } from 'vue';
import axios from 'axios';
import { reactive } from '@vue/reactivity';

import MainChartcomp from '../components/chart/drawChart/MainChartcomp';

const totalPrice = ref();
const flage = ref(false);
const dataset = reactive({
  labels: [],
  datasets: [
    {
      data: [],
    },
  ],
});

const dataset2 = reactive({
  labels: [],
  datasets: [
    {
      data: [],
    },
  ],
});
// axios

axios
  .post('/api/chart/card/totalPrice', {
    beforeDate: '2022/12/05',
    afterDate: '2023/01/05',
  })
  .then(res => {
    totalPrice.value =
      res.data.result[0].totalPrice.toLocaleString('ko-KR') + '원';
  });

function monthPrice() {
  axios.post('/api/chart/card/monthPrice').then(res => {
    res.data.result.forEach(i => {
      dataset2.datasets[0].data.push(i.totalPrice);
      dataset2.labels.push(i.useDate);
    });
  });
}
onMounted(() => {
  axios
    .post('/api/chart/card/selectAll', {
      beforeDate: '2022/12/05',
      afterDate: '2023/01/05',
    })
    .then(res => {
      res.data.result.forEach(i => {
        dataset.datasets[0].data.push(i.totalPrice);
        dataset.labels.push(i.shopName);
        flage.value = true;
      });
    });
  monthPrice();
});
</script>
<template>
  <div
    class="q-pa-md"
    style="display: flex; flex-direction: column; row-gap: 10px"
  >
    <q-card class="my-card">
      <q-card-section>
        <div class="text-h6">12.05 ~ 01.05</div>
        <div class="text-subtitle2">카드 사용 내역</div>
        <div class="text-subtitle3">{{ totalPrice }}</div>
        <div>
          <MainChartcomp
            :dataset="dataset"
            type="bar"
            ref="test1"
            v-if="flage"
            width="1100"
          />
        </div>
      </q-card-section>
    </q-card>
    <q-card class="my-card">
      <q-card-section>
        <div class="text-subtitle2">월별 사용 액</div>
        <div>
          <MainChartcomp
            :dataset="dataset2"
            type="bar"
            ref="test1"
            v-if="flage"
            width="1100"
          />
        </div>
      </q-card-section>
    </q-card>
  </div>
</template>
