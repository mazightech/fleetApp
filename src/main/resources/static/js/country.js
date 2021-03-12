$('document').ready(function () {

    $('table #editButton').on('click', function (event) {
        event.preventDefault();
        //Get country elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (country, status) {
            $('#id-edit').val(country.id);
            $('#description-edit').val(country.description);
            $('#capital-edit').val(country.capital);
            $('#code-edit').val(country.code);
            $('#continent-edit').val(country.continent);
            $('#nationality-edit').val(country.nationality);
         });
        // show edit modal
        $('#editModal').modal();
    });

    $('table #deleteButton').on('click', function (event) {
       event.preventDefault();

       // pass delete link from  href html to href of modal
        var href = $(this).attr('href');
        $('#confirmdelete').attr('href', href);

        //show delete pop modal
        $('#deleteModal').modal();
    });

});