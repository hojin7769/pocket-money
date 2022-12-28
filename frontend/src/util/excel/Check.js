const check = {
  nameCheck: nameValue => {
    const name = String(nameValue);
    if (name.includes('카드')) {
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
