import { date } from 'quasar';
const menuTable = {
  options: [
    {
      label: '전체',
      value: '',
      description: 'Search engine',
      category: '1',
    },
    {
      label: '메뉴코드',
      value: 'codeMenu',
      description: 'Search engine',
      category: '1',
    },
    {
      label: '메뉴명',
      value: 'nameMenu',
      description: 'Social media',
      category: '1',
    },
    {
      label: '메뉴Path',
      value: 'pathMenu',
      description: 'Quick updates',
      category: '2',
    },
    {
      label: '메뉴Router',
      value: 'dsRouter',
      description: 'iStuff',
      category: '2',
    },
    {
      label: '작성자',
      value: 'nmInserter',
      description: 'Databases',
      category: '3',
    },
  ],
  columns: [
    {
      name: 'snSeq',
      required: true,
      label: '번호',
      align: 'left',
      style: 'width:100px',
      field: row => row.snSeq,
      format: val => `${val}`,
    },
    {
      name: 'menuName',
      align: 'center',
      label: '메뉴명',
      style: 'width:100px',
      field: 'menuName',
    },
    {
      name: 'menuCode',
      label: '메뉴코드',
      field: 'menuCode',
      style: 'width:100px',
      sortable: true,
      format: val => `${val}`,
    },
    { name: 'menuIcon', label: '메뉴아이콘', field: 'menuIcon' },
    {
      name: 'menuOrder',
      label: '메뉴순서',
      field: 'menuOrder',
      style: 'width:200px',
      format: val => `${val}`,
    },
    {
      name: 'menuPath',
      label: '메뉴Path',
      field: 'menuPath',
      style: 'width:200px',
      format: val => `${val}`,
    },
    {
      name: 'menuRouter',
      label: '메뉴라우터',
      field: 'menuRouter',
      sortable: true,
    },
  ],
};
export default menuTable;
