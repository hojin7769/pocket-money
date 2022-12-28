import * as XLSX from "xlsx";

function readCardExcel(value,callBackFN){
    console.log(value);
    const reader = new FileReader();
    reader.onload = function () {
        let data = reader.result;
        let workBook = XLSX.read(data, { type: 'binary' });

        workBook.SheetNames.forEach(sheetName => {
            let rows = XLSX.utils.sheet_to_json(workBook.Sheets[sheetName], {
                header: 0,
                range: 6,
                defval: '',
            });
            callBackFN(rows);
        });
    };
    reader.readAsBinaryString(value);
}


export {
    readCardExcel
}