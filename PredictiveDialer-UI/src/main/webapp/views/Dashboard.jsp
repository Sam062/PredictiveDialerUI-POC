<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html>
    <html>

    <head>
        <title>Home Page</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.css">

        <script src="https://code.jquery.com/jquery-3.6.0.js"
            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
        <script type="text/javascript" charset="utf8"
            src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"
            integrity="sha512-bztGAvCE/3+a1Oh0gUro7BHukf6v7zpzrAb3ReWAVrt+bVNNphcl2tDTKCBr5zk7iEDmQ2Bv401fX3jeVXGIcA=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js"
            integrity="sha512-4WpSQe8XU6Djt8IPJMGD9Xx9KuYsVCEeitZfMhPi8xdYlVA5hzRitm0Nt1g2AZFS136s29Nq4E4NVvouVAVrBw=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>

        <script src="../js/app.js"></script>

        <script>
            function myFun() {
                document.getElementById('clickToCall').click();
            }
        </script>
    </head>

    <body>
        <div>
            <table class="table" style="height: 34rem;">
                <tr>
                    <td style="text-align: center; background: darkseagreen; color: aliceblue; cursor: pointer;"
                        onclick="myFun()">
                        <a href="welcome" style="display: none;" id="clickToCall"></a>
                       <h3 class="display-1" style="color: black;"> Call</h3>
                    </td>
                    <td style="text-align: center; background: palevioletred;">
                        <h3 class="display-1"> Agent</h3>
                    </td>
                </tr>
                <tr>
                    <td style="text-align: center; background: darkslateblue;">
                        <h3 class="display-1" style="color: whitesmoke;"> Data Feed</h3>
                    </td>
                    <td style="text-align: center;background: darkgoldenrod;">
                        <h3 class="display-1"> Other</h3>
                    </td>
                </tr>
            </table>
        </div>

    </body>

    </html>