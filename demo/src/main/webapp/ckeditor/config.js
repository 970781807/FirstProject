CKEDITOR.editorConfig = function (config) {
    config.toolbar = [
        {name: 'document', items: ['Source', '-', 'Save', 'NewPage', 'Preview']},
        {name: 'editing', items: ['Find', 'Replace', '-', 'Scayt']},
        {
            name: 'basicstyles',
            items: ['Bold', 'Italic', 'Underline', 'Strike', 'Subscript', 'Superscript', '-', 'CopyFormatting', 'RemoveFormat']
        },
        {
            name: 'paragraph',
            items: ['NumberedList', 'BulletedList', '-', 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock', '-']
        },
        {name: 'insert', items: ['Image', 'Table', 'HorizontalRule', 'Smiley', 'SpecialChar']},
        {name: 'tools', items: ['Maximize', 'ShowBlocks']},
        '/',
        {name: 'styles', items: ['Styles', 'Format', 'Font', 'FontSize']},
        {name: 'colors', items: ['TextColor', 'BGColor']}
    ];
    config.autoEmbed_widget = 'customEmbed';
};