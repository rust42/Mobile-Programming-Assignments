package edu.miu.cs473.walmartapp

class ProductFactory {
    companion object {
        val electronics: Array<Product> = arrayOf(
            Product("RGA Voyager 7\" 16GB Android Tablet",
                35.0,
                "black",
                "rga_voyager",
                1,
                """
                   Introducing the RGA Voyager 7-inch Google Certified Tablet. Operating on Android's sweetest operating system yet, Android 6.0 (Marshmallow), you can enjoy more of what the Google Play store has to offer.
                   """),
            Product("HP Flyer Red 15.6\" Laptop",
                299.0,
                "black & red",
                "hp_flyer_red",
                2,
                """Intel Pentium N3540 processor4GB memory500GB hard driveWindows 10 HomeThis reliable, value-packed laptop combines the features you need to get the job done and a sleek, thin design you can easily take on the road.Key Features and Benefits:Intel Pentium N3540 processor2.16GHz (with Max Turbo Speed of 2.66GHz)4GB DDR3L SDRAM system memoryGives you the power to handle most power-hungry applications and tons of multimedia work500GB SATA hard driveStore 333,000 photos, 142,000 songs or 263 hours of HD video and moreSuperMulti DVD BurnerWatch movies and read and write CDs and DVDs in multiple formats
        """),
            Product("Vizio 70\" Class 4K" ,
                1298.0,
                "black",
                "vizio_70_inch",
                3,
                """Escape into awesome entertainment with the VIZIO V-Series 4K UHD Smart TV. With epic 4K UHD picture quality, Dolby Vision Bright Mode, HDR10, a full array backlight, and active pixel tuning, V-Series provides crystal-clear and sharp picture quality. The next-gen speed and power of the VIZIO IQ Active processor brings astonishing detail and vibrancy to your viewing experience. Take your gaming to a whole new level with the V-Gaming engine which enables sub 10ms input lag, 4K 48-60 fps Variable Refresh Rate, Auto Game Mode, and a newly added gaming menu. Stream it all with the award-winning SmartCast platform loaded with the best selection of built-in apps including WatchFree+ that lets you enjoy free access to live TV and hundreds of free channels right out of the box. Pair your favorite Bluetooth headphones and hear every word – uninterrupted. SmartCast also works with Apple AirPlay 2 and Chromecast built-in, offering unparalleled entertainment in a size that fits your lifestyle. V-series is everything you need and more in a Smart TV delivering a standout experience at an unmatched price.
            """),
            Product("Epson Workforce WF-2750",
                69.0,
                "black",
                "epson_workforce",
                4,
                """Fast and reliable, the WorkForce WF-2750 all-in-one printer offers easy wireless printing for your home office. Powered by revolutionary PrecisionCore® printing technology, the WF-2750 delivers Laser-Quality Performance. You can print sharp, professional-quality documents – even from your iPad®, iPhone®, Android™ tablet or smartphone1. Productivity-boosting features include auto 2-sided printing and a 30-page Auto Document Feeder, plus a 150-sheet capacity, so you'll reload paper less often. Affordable individual ink cartridges allow you to replace only the color you need. Plus, the printer's 2.2" mono graphic display makes navigation simple.
            """),
        )


         val beauties: Array<Product> = arrayOf(
            Product("Alo Supernatural Deodorant",
                18.0,
                "",
                "alo_deodrant",
                1,
                """
                   Alo Yoga is releasing its Supernatural Deodorant on Feb. 25. The product is made with amla berry, vitamin C and tea tree oil to refresh and hydrate the underarms.
                   """),
            Product("Alpyn Beauty Bearberry & Vitamin C Glow Serum",
                59.0,
                "",
                "alpyn_serum",
                2,
                """
Alpyn Beauty’s new serum is said to brighten and hydrate the skin with ingredients like vitamin C, bearberry root and a plant-based squalene.
        """),
            Product("Beautyblender Beam Shadeshifter Makeup Sponge" ,
                20.0,
                "black",
                "beautyblender_shade",
                3,
                """
Beautyblender’s latest makeup sponge is made with a heat-activated technology that makes it transform from a soft orange color to a bright yellow when it’s soaked in water.
            """),
            Product("Byoma Creamy Jelly Cleanser",
                11.99,
                "",
                "byoma_cleanser",
                4,
                """
Byoma, a new skin-care brand that offers barrier-boosting products, launched this month with seven products, including this Creamy Jelly Cleanser. The product is made with a tri-ceramide complex, antioxidant rich licorice root and green tea to cleanse the skin while still keeping it hydrated.
            """),

            Product("Charlotte Tilbury Collagen Superfusion Facial Oil",
                80.0,
                "",
                "collagen_oil",
                4,
                """
Charlotte Tilbury’s new skin-care product is a facial oil made with plant-derived protein and collagen to hydrate, plump and smooth the skin.
            """),

            Product("Ctzn Cosmetics Code Red Collection",
                28.0,
                "",
                "ctzn_cosmetics_reds",
                4,
                """
Ctzn Cosmetics is bringing that ethos to its first collection of red lipstick with a range of six shades that are made with shea butter and raspberry extract to hydrate the lips.            """),

            Product("Dove Body Wash Reusable Bottle + Concentrate Refills",
                14.99,
                "",
                "dove_body_wash",
                4,
                """
Dove is continuing its mission to eliminate plastic waste with the launch of a reusable and refillable body wash. The body wash’s bottle comes in a reusable, 100 percent recycled plastic or a recyclable aluminum that can be refilled repeatedly.
            """),

            Product("Freck Beauty Lashrocket Liner With Lash Enhancing Peptides",
                24.0,
                "",
                "freck_eye_liner",
                4,
                """
Known for its best-selling freckle pens, Freck Beauty is introducing a multitasking eye liner that comes in a jet black color and also provides the lashes with a serum that’s said to promote fuller and longer lashes.
            """),
            Product("Joah Beauty Perfect Complexion Eye Serum Concealer",
                11.99,
                "",
                "joah_serum",
                4,
                """
Joah Beauty is launching a two-in-one concealer serum that provides coverage while hydrating the undereye area.
            """),
            Product("Merit Signature Lip Lightweight Lipstick",
                26.00,
                "",
                "merit_lipstick",
                4,
                """
Merit has launched a hydrating, buildable lipstick collection this month that debuted at New York Fashion Week during Proenza Schouler’s fall 2022 fashion show. The collection offers eight shades.
            """),
            Product("Neutrogena Scalp Therapy Anti-Dandruff",
                11.99,
                "",
                "neutrogena_shampoo",
                4,
                """
Neutrogena has launched a new scalp therapy line of shampoos that are said to address flakiness, irritation, redness and itchiness. The line offers four products: daily control, extra strength, build-up control and itchy scalp.
            """),

            )

        val food = arrayOf(
            Product("Marketside Fresh Spinach, 10 oz",
                2.28,
                "",
                "fresh_spinach",
                1,
                """"
                Marketside Fresh Spinach Leaves have a smooth, tender texture and great wholesome taste that is loaded with nutrients. This spinach is packed fresh, washed and ready to eat for your convenience. Use it to create your very own personalized salad tossed with your favorite vegetables, protein, nuts and dressing. Use it as a topping on sandwiches and pizzas, or simply enjoy it as a healthy side. It offers nutritional benefits as it is a rich source of vitamins A, C and iron. Enjoy fresh from the farm taste with Marketside Fresh Spinach.Fresh ideas and quality ingredients, that's how Marketside brings the best foods to your table.
                """,
            ),

            Product("Fresh Strawberries, 1 lb",
                4.68,
                "",
                "strawberries",
                2,
                """,
The sweet, juicy flavor of Fresh Strawberries make them a refreshing and delicious treat. Enjoy them for breakfast, lunch, dinner, or dessert. Use them as topping for pancakes, bake them in a mouthwatering bread, mix them with cucumbers for a light and flavorful salad, or puree them for strawberry shortcake. They contain essential vitamins and nutrients like vitamin C, fiber, potassium, vitamin B and magnesium making them perfect for a healthy diet.                
            """
            ),

            Product("Fresh Blueberries, 11 oz or 1 Pint",
                2.48,
                "",
                "blueberries",
                3,
                """,
Create decadent meals with sweet and light Fresh Blueberries. Enjoy them for breakfast, lunch, dinner, or dessert. Use them to make a lemon and blueberry galette, bake them into delicious blueberry muffins, cook up a sweet and savory pizza topped with blueberries and bacon, or reduce them for a sauce to use on grilled chicken or cheesecake. They contain essential vitamins and nutrients like, vitamin C, vitamin K, antioxidants, and manganese making them perfect for a healthy diet. Prior to serving simply gently wash them with cool water and enjoy the fresh taste.             """
            ),

            Product("Pomegranate, each",
                2.48,
                "",
                "pomegranate",
                4,
                """,
Add a some zing to your meals with with Fresh Pomegranate. It has a sweet and tangy flavor that's made it a Mediterranean favorite for centuries. Pomegranate fruit is soft and tender and you can squeeze it for juice.        ),
"""),
            Product("Pineapple",
                1.94,
                "",
                "pineapple",
                5,
                """,
Pineapple Cored
"""),

            Product("Fresh Cranberries, 12 oz",
                1.50,
                "",
                "cranberries",
                6,
                """
Savor the tart taste of Fresh Cranberries. Cranberries have a wonderful tart flavor that can easily take on the sweetness of your favorite sweetener. Use them to make a tart cranberry sauce, bake them into delicious cranberry and orange scones, combine with baked Brie for a gooey, sweet appetizer, or reduce them for a glaze to use on grilled chicken or turkey. They contain essential vitamins and nutrients like vitamin C, vitamin B, fiber, and antioxidants making them perfect for a healthy diet.                        
                    """),

            Product("All Natural Whole Turkey | 11-14 lbs.",
                130.0,
                "",
                "natural_turkey",
                7,
                """
 Certified Halal, Hand Processed, Antibiotic-Free, No added Hormones, Humanely Raised, Fed 100% Vegetarian Diet and USDA Inspected.
        """)
        )

        val clothes = arrayOf(
            Product("George Men's Long Sleeve Flannel Shirt",
                11.98,
                "",
                "george_shirt",
                1,
                """
          The George Men's Long Sleeve Flannel Shirt made from a cotton and viscose fabric for a soft, comfortable fit. A classic flannel shirt is a must-have for every wardrobe. Perfect for cooler days, wear buttoned up with everyday jeans or leave open with a graphic print tee for a more casual look.  
            """
            ),
            Product("Wrangler Men's and Big Men's Relaxed Fit Cargo Pants With Stretch",
                21.98,
                "",
                "wrangler_cargo_pants",
                1,
                """
We have taken our hardest working and functional cargo pants and made them even more comfortable. Made with a relaxed and generous fit and with enough stretch that moves with you, our Cargo Pants are a must-have for knocking off your to-do list, or relaxing with friends over the weekend. Featuring welt hip pockets and front and side cargo pockets for storing essentials, you'll have plenty of room to keep your technology and essentials handy. So take on the day with ease and comfort and let our cargos do all the work for you.            """
            ),
            Product("Casio Men 200m Water Resistant Diver Analog Watch",
                54.92,
                "",
                "casio_watch",
                1,
                """
Inspired by the sea, this watch black resin band and stainless steel case with blue dial and bezel give it a classic look. Simple 3-hand analog with date display for an easy-read.
"""
            ),
            Product("Gelante Beanie Hat Men Women Classic Knit Cuffed Plain Cap - Army Green",
                6.99,
                "",
                "gelantie_hat",
                1,
                """
Gelante Adult Unisex Knitted Beanie hat cap with cuffed one size fits all will keep your head warm in the winter time.
- The Knit Beanie Cap is the perfect item for any winter wear
- Material: 100% Acrylic / Soft & Warm
- Size: Stretchable, One Size Fits All. Measurement: 12 inch long unfolded / 9 inch long folded
"""
            ),
            Product("Holiday Time Men's Chimney Santa Ugly Christmas Sweater",
                23.98,
                "",
                "holiday_sweater",
                1,
                """
Ho-Ho-Hilarious! Get into the holiday spirit with this Long Sleeve Crewneck Ugly Christmas Sweater from Holiday Time! Tis the season with a holly jolly men’s sweater featuring a fun holiday-themed design. Perfect for the next festive get-together, this men’s knit sweater is highlighted by its colorful Christmas details.
- Material: 100% Acrylic
- Care: Machine washable
- Country of Origin: Imported
- Size: Model is 6’1” and is wearing a size M
- Fit: Relaxed
- Closure: Pullover style
- Sleeves: Long
- Pockets: Front beverage pocket
- Features: Crewneck; contrast prints
- Men's Ugly Christmas Sweater from Holiday Time
"""
            ),
            Product("SpongeBob Men's Socks, 6-Pack",
                11.98,
                "",
                "sponge_bob_socks",
                4,
                """
Take your favorite characters everywhere you go in these super fun SpongeBob-themed 6-Pack of socks. Complete with a mix of zany designs, these socks add a cool yet versatile addition to your basics, while keeping your feet comfy with their soft knit fabric and stretch construction. The classic crew silhouette makes them standout with every shoe you pair them with.
- Material: Sock 1, 3, 4, 5, 6 - 98% Polyester/2% Spandex Sock 2 - 97% Polyester/3% Spandex
- Care: Machine washable
- Country of Origin: Imported
- 6-Pack Includes: Six pairs of crew socks
- Fits Shoe Size: 8-12
- Features: Allover print
- ©Nickelodeon. All Rights Reserved.
- SpongeBob Crew Socks 6-Pack for Men             
            """
            ),
            Product("AND1 Men's Maverick Basketball High-Top Sneakers",
                22.98,
                "",
                "and_men_shoe",
                5,
                """
Storm the court and make a statement with the And1 Maverick. This bold and stylish sneaker is built for performance to help you control the game, on the blacktop or hardwood. This high top lace up sneaker is sure to change your game for the better and keep your feet secure and comfortable for every last play, into overtime, and on the walk home as well.

- Basketball Shoes
- Stylish Sneaker
- High top lace up sneaker
- Non-Marking Outsole
- PU Upper, Rubber Insole
- Color: Black, Gray, White
- Imported          
            """),
            Product("George Men's Trapper Moccasin Slipper",
                18.98,
                "",
                "george_slipper",
                6,
                """
This Mens George Trapper Moccasin Slipper is made with genuine suede leather upper. This slip on style slipper has a plush lining and sock, plus a foam padded sock for comfort. This Mens George Sock plush Slipper also has a durable TPR rubber sole for great indoor and outdoor use.
- genuine suede upper
- laced moc
- comfort sock
- durable TPR outsole
- plush fur linings
- indoor and outdoor use
- easy on and off slip on design
- padded sock
- moccasin slipper
        """),
            Product("Slim Minimalist Front Pocket Wallets For Men & Women - Genuine Leather Credit Card Holder W/ Thumbhole RFID Wallet With Gift Box",
                14.99,
                "",
                "slim_pocket_wallet",
                7,
                """
This slim wallet for men is handmade out genuine full grain leather that is extremely soft and durable. The craftsmanship that was put into making this wallet can give you the courage that it will last for years. It's minimalistic design and smooth texture makes it the perfect wallet to use every single day. This Card Holder is only 1/8 of an inch thick, and measures 4.3 inches long and 2.75 inches wide. We designed this wallet to be small and compact, built for exactly what you need. It contains 4 credit card slots, 1 ID Window, and 1 Cash compartment. You can also use the cash compartment as an extra area to add more cards. Knowing most people mainly use one card for the majority of their purchases, we added a thumb hole to the first card slot, making it extremely accessible and convenient to pull out your favorite card! Additionally, we added a thumb hole on the ID Window, making ones life so much simpler when taking their ID in and out of their wallet. This wallet was designed to make using your wallet so much easier, giving you effortless access to all your cards, and never having to struggle to remove your cards or ID. Our Minimalist Wallet is beautifully packaged in a neat gift box, paper wrapped on the inside, making it a no brainer for a gift. You can gift this wallet for all events such as Birthdays, Christmas, Valentine's Day, Mother's Day, Father's Day, Business Gifts, Corporate Gifts, Groomsmen, Brides, and all other special occasions. Treat your loved ones with a high quality leather RFID wallet, so they can be reminded of you every time they use their wallet.
        """),
            Product("Dearfoams Cozy Comfort Papa Bear Plaid Clog Slippers",
                11.98,
                "",
                "papa_bear_slipper",
                8,
                """
The family that cuddles together, stays together! Perfect for Papa Bear, these slippers feature cushioned memory foam insoles, durable indoor/outdoor outsoles, cozy flannel lining, and charming designs that look great next to the other members of our Matching Family Collection. With styles for Papa Bear, Mama Bear, Lil Bear, and Baby too - everyone can get comfy together!                
            """)
        )

    }
}