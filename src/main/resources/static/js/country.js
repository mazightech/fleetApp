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

            $('#edit').on('click', function () {
                $('#id-edit').val(country.id);
            });
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

    //Validate Add Country
    $('.addCountry').validate({
        rules: {
            "description": {
                required: true,
                minlength: 2,
                pattern: '[a-zA-Z]+'
            },
            "capital": {
                required: true,
                minlength: 2,
                pattern: '[a-zA-Z]+'
            },
            "code": {
                required: true,
                minlength: 2,
                pattern: '[0-9]{3}'
            },
            "continent": {
                required: true,
                minlength: 2,
                pattern: '[a-zA-Z]+'
            },
            "nationality": {
                required: true,
                minlength: 2,
                pattern: '[a-zA-Z]+'
            }
        }
    });

    //Validate Edit Country
    $('.editCountry').validate({
        rules: {
            "description-edit": {
                required: true,
                minlength: 2,
                pattern: '[a-zA-Z]+'
            },
            "capital-edit": {
                required: true,
                minlength: 2,
                pattern: '[a-zA-Z]+'
            },
            "code-edit": {
                required: true,
                minlength: 2,
                pattern: '[0-9]{3}'
            },
            "continent-edit": {
                required: true,
                minlength: 2,
                pattern: '[a-zA-Z]+'
            },
            "nationality-edit": {
                required: true,
                minlength: 2,
                pattern: '[a-zA-Z]+'
            }
        }
    });

});