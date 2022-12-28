const check = {
  nameCheck: nameValue => {
    const name = String(nameValue)
    const regex = /[^신한카드]/
    if (regex.test(name)) {
      return '카드';
    } else {
      return '은행';
    }
  },
  nullCheck: object => {
    if (object === null) {
      return '';
    } else if (typeof object === 'number') {
      return 0;
    }
  },
};

export default check;
