            var k = 0;
            document.getElementById("order").disabled = true;
            document.getElementById("add").disabled = true;
            document.getElementById("lockOrder").disabled = true;
            function calculatePrice(p1, p2, quantity) {
                var price = (p1 + p2) * quantity;


                return price;
            }
            var money = $('input[id="money"]').val();

            var bL = $('input[id="bot0"]').val();
            for (var i = 0; i <= bL; i++) {
                document.getElementById("bot" + i).addEventListener('click', run);
            }
            var tL = $('input[id="top0"]').val();

            for (var j = 0; j <= tL; j++) {
                document.getElementById("top" + j).addEventListener('click', run);
            }
            document.getElementById("quantity").addEventListener('click', run);
            document.getElementById("add").addEventListener('click', add);
            document.getElementById("lockOrder").addEventListener('click', order);



            function run() {

                var p1;
                var p2;
                var quantity;
                var valueBot = $('input[name="bot"]:checked').val();
                var valueTop = $('input[name="top"]:checked').val();
                quantity = $('input[id="quantity"]').val();
                p1 = valueBot.substring(0, 1);
                p2 = valueTop.substring(0, 1);
                p1 = parseInt(p1);
                p2 = parseInt(p2);
                quantity = parseInt(quantity);
                var price = calculatePrice(p1, p2, quantity);
                var moneyLeft = checkMoney(price, money);
                document.getElementById("priceThisCake").innerHTML = "Price: " + price;

                if (moneyLeft >= 0) {
                    document.getElementById("add").disabled = false;
                } else {
                    document.getElementById("add").disabled = false;
                }
            }




            function checkMoney(price, money) {
                return money - price;
            }


            function add()
            {
                var valueBot = $('input[name="bot"]:checked').val();
                var valueTop = $('input[name="top"]:checked').val();
                quantity = $('input[id="quantity"]').val();
                var p1 = valueBot.substring(0, 1);
                var p2 = valueTop.substring(0, 1);
                p1 = parseInt(p1);
                p2 = parseInt(p2);
                var nameBot = valueBot.substring(2);
                var nameTop = valueTop.substring(2);

                var ordered = document.getElementById("ordered");
                ordered.innerHTML +=
                        '<tr>' +
                        '<td>' + nameTop + '</td>' +
                        '<td>' + nameBot + '</td>' +
                        '<td>' + (p1 + p2) + '</td>' +
                        '<td>' + quantity + '</td>' +
                        '<td>' + calculatePrice(p1, p2, quantity) + '</td>' +
                        '</tr>';

                var orderForm = document.getElementById("orderForm");
                orderForm.innerHTML +=
                        '<input type="hidden" name="top' + k + '" value="' + nameTop + '">' +
                        '<input type="hidden" name="bot' + k + '" value="' + nameBot + '">' +
                        '<input type="hidden" name="quantity' + k + '" value="' + quantity + '">';
                k++;
                var total = 0;
                var table = document.getElementById("orders");
                var rows = $('#orders tr').length;
                rows = parseInt(rows);
                for (var i = 1; i < rows; i++) {
                    total += parseInt(document.getElementById("orders").rows[i].cells[4].innerHTML);
                }
                var checkOrder = checkMoney(total, money);
                if (checkOrder >= 0) {
                    document.getElementById("lockOrder").disabled = false;
                } else {
                    document.getElementById("lockOrder").disabled = true;
                }
            }

            function order() {

                var orderForm = document.getElementById("orderForm");
                orderForm.innerHTML +=
                        '<input type="hidden" name="k" value="' + k + '">';
                
                document.getElementById("order").disabled = false;
                document.getElementById("add").disabled = true;
            }