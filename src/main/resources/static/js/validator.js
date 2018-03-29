function validate(formId, serializeObject) {

    var noError = true;
    for (var key in serializeObject) {

        if (serializeObject[key] === '') {
            var element = $('#' + formId).find('*[name=' + key + ']');

            var validate = JSON.parse($(element).attr('validate'));

            if (validate) {

                var msg = '不能为空';
                if ($(element).attr('msg') !== '') {
                    msg = $(element).attr('msg');
                }


                if ($(element).attr('remote') !== '') {

                    var validateData = {};
                    validateData[key] = serializeObject[key];

                    $.ajax({
                        url: $(element).attr('remote'),
                        type: 'POST',
                        data: validateData,
                        success: function (data) {

                        }
                    });
                }

                layer.tips(msg, element, {
                    tips: [1, '#ff6b68'],
                    tipsMore: true
                });

            }

            noError = false;
        }

    }

    return noError;
}