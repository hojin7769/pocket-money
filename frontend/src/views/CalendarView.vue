<script>
import { QCalendarDay, today } from '@quasar/quasar-ui-qcalendar/src/index.js';
import '@quasar/quasar-ui-qcalendar/src/QCalendarVariables.sass';
import '@quasar/quasar-ui-qcalendar/src/QCalendarTransitions.sass';
import '@quasar/quasar-ui-qcalendar/src/QCalendarDay.sass';

import { defineComponent } from 'vue';
import AddCalendar from '../components/Calendar/AddCalendar.vue';

export default defineComponent({
  name: 'DayDateType',
  components: {
    QCalendarDay,
    AddCalendar,
  },
  data() {
    return {
      selectedDate: today(),
      dateType: 'square',
      dialog: false,
    };
  },
  methods: {
    onToday() {
      this.$refs.calendar.moveToToday();
    },
    onPrev() {
      this.$refs.calendar.prev();
    },
    onNext() {
      this.$refs.calendar.next();
    },

    onMoved(data) {
      console.log('onMoved', data);
    },
    onChange(data) {
      console.log('onChange', data);
    },
    onClickDate(data) {
      console.log('onClickDate', data);
      this.dialog = true;
    },
    onClickTime(data) {
      console.log('onClickTime', data);
      this.dialog = true;
    },
    onClickInterval(data) {
      console.log('onClickInterval', data);
    },
    onClickHeadIntervals(data) {
      console.log('onClickHeadIntervals', data);
    },
    onClickHeadDay(data) {
      console.log('onClickHeadDay', data);
    },
  },
});
</script>
<template>
  <div class="subcontent">
    <navigation-bar @today="onToday" @prev="onPrev" @next="onNext" />

    <div class="q-ma-sm row justify-center">
      <q-radio
        v-model="dateType"
        val="round"
        label="round"
        dense
        style="min-width: 100px"
      />
      <q-radio
        v-model="dateType"
        val="rounded"
        label="rounded"
        dense
        style="min-width: 100px"
      />
      <q-radio
        v-model="dateType"
        val="square"
        label="square"
        dense
        style="min-width: 100px"
      />
    </div>

    <div class="row justify-center">
      <div style="display: flex; max-width: 800px; width: 100%; height: 400px">
        <q-calendar-day
          ref="calendar"
          v-model="selectedDate"
          :date-type="dateType"
          animated
          bordered
          @change="onChange"
          @moved="onMoved"
          @click-date="onClickDate"
          @click-time="onClickTime"
          @click-interval="onClickInterval"
          @click-head-intervals="onClickHeadIntervals"
          @click-head-day="onClickHeadDay"
        />
      </div>
    </div>
    <AddCalendar
      :dialog="dialog"
      v-if="dialog"
      @closePopup="dialog = false"
    ></AddCalendar>
  </div>
</template>

<style src="@quasar/quasar-ui-qcalendar/dist/QCalendarDay.min.css"></style>
