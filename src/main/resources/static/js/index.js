
var main = {
    init: function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.itemSave();
        });
    },
    itemSave : function () {
        var data = {
            name: $('#name').val(),
            price: $('#price').val(),
            quantity: $('#quantity').val(),
            category: $('#category').val()
        };

        //jQuery에서 제공하는 ajax를 사용하여 간단하게 서버와 데이터 통신 가능
        $.ajax({
            type: 'POST',
            url: '/api/item/save',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('상품이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();