$('a.menu-item').click(function () {
    $('li.active').removeClass('active');
    $('li.dropdown').removeClass('active');
    $(this).parent().addClass('active');
});
$('a.dropdown-item').click(function () {
    $('li.active').removeClass('active');
    $('li.dropdown').addClass('active');
});
$('a.navbar-brand').click(function() {
    $('li.active').removeClass('active');
    $('li.dropdown').removeClass('active');
});