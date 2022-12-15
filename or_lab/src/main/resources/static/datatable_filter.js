$(document).ready(function () {
    // Setup - add a text input to each footer cell
    $('#turniriFilterTable tfoot th').each(function () {
        var title = $(this).text();
        $(this).html('<input type="text" placeholder="Search ' + title + '" />');
    });

    // DataTable
    var table = $('#turniriFilterTable').DataTable({
        dom: 'Bfrtip',
        buttons: [
            'csv',
            {
                text: 'JSON',
                action: function (e, dt, button, config) {
                    var data = dt.buttons.exportData();

                    $.fn.dataTable.fileSave(
                        new Blob([JSON.stringify(data)]),
                        'turniri.json'
                    );
                }
            }
        ],
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

        ],
        initComplete: function () {
            // Apply the search
            this.api()
                .columns()
                .every(function () {
                    var that = this;

                    $('input', this.footer()).on('keyup change clear', function () {
                        if (that.search() !== this.value) {
                            that.search(this.value).draw();
                        }
                    });
                });
        }

    });
});