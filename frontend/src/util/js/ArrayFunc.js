/* eslint-disable no-unused-vars */
const arrayFunc = {
  remove: (arr, data) => {
    let index = arr.indexOf(data);
    let length = arr.length;
    arr.splice(index, index + 1);
    return arr;
  },
};

export default arrayFunc;
