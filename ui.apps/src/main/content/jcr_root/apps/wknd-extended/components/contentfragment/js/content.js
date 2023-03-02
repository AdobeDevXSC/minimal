use(function () {
    try{
        const allowImageTypes = ['jpg', 'jpeg', 'gif', 'png'];
        const content = String(this.content);
        var output = content;
        const contentExtension = content.split('.').pop().toLowerCase();

        if(allowImageTypes.indexOf(contentExtension) > -1){
            output = '<img src="' + content + '" />';
        }

    }
    catch (error) {
		return;
    }

    return output;
});