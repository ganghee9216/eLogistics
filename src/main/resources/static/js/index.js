
var main = {
    init: function () {
        var _this = this;
        $('#btn-item-save').on('click', function () {
            _this.itemSave();
        });
        $('#btn-item-update').on('click', function () {
            _this.itemUpdate();
        });
        $('#btn-item-delete').on('click', function () {
            _this.itemDelete();
        });
        $('#btn-order-save').on('click', function () {
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
    },
    itemUpdate : function () {
        var id = $('#id').val();
        var data = {
            name: $('#name').val(),
            price: $('#price').val(),
            quantity: $('#quantity').val(),
            category: $('#category').val()
        };
        $.ajax({
            type: 'PUT',
            url: '/api/item/'+id,
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('상품이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    itemDelete : function () {
        var id = $('#id').val();
        $.ajax({
            type: 'DELETE',
            url: '/api/item/'+id,
            contentType: 'application/json; charset=utf-8'
        }).done(function () {
            alert('상품이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();