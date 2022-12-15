$(document).ready( function () {
    var table = $('#turniriTable').DataTable({
        "responsive" : true,
        "sAjaxSource": "/turniri",
        "sAjaxDataProp": "",
        "order": [[ 0, "asc" ]],
        "aoColumns": [
            { "mData": "idTurnir" },
            { "mData": "naziv"},
            { "mData": "serija" },
            { "mData": "organizator" },
            { "mData": "tip" },
            { "mData": "lokacija"},
            { "mData": "format" },
            { "mData": "datumPocetka" },
            { "mData": "datumZavrsetka" },
            { "mData": "nagradniFond"},
            { "mData": "brojTimova" },
            { "mData": "brojGledatelja" },
            { "mData": "verzijaIgre" }
        ]
    })
});