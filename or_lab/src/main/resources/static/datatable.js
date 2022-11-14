$(document).ready( function () {
    var table = $('#turniriTable').DataTable({
        "sAjaxSource": "/turniri",
        "sAjaxDataProp": "",
        "order": [[ 0, "asc" ]],
        "aoColumns": [
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
            { "mData": "verzijaIgre" },
            { "mData": "idTurnir" }
        ]
    })
});