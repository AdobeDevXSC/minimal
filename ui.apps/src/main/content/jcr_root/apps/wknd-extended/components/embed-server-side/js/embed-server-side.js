use(function () {
    try{
        const apiurl = this.apiurl;
        var output = '';

        if(apiurl) {
            var client = new org.apache.commons.httpclient.HttpClient();
            var resourceURL = new java.net.URL(apiurl);
            var urlConnection = resourceURL.openConnection();
            var inputStream = new java.io.InputStreamReader(urlConnection.getInputStream());
            var bufferedReader = new java.io.BufferedReader(inputStream);
            var inputLine = bufferedReader.readLine();
            bufferedReader.close();
            output = String(inputLine);
        }

    }
    catch (error) {
        output = 'error: ' + error;
    }

    return output;
});