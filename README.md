# p-pe

P - pe is ready to integrate payment gateway for small businesses who are willing to have international trade. P-pe helps businesses to achieve dynamic pricing model using purchasing power parity concept. big businesses such as Netflix, google one subscription are very intelligently using concept of PPP, but small businesses do not have resoources to do so. 

some basics:
price : price of 1 USD is 80 INR, this is influenced by demographics, economy
value : price of 1 USD is 23 INR[ as purchasing power parity of INDIA/ USA is 23]

The idea is to make purchases affordable.
If I have 1 USD I want to spend it in USA, its about 23 rs

IMF Defination:
The rate at which the currency of one country would have to be converted into that of another country to buy the same amount of goods and services in each country

Let;s go by an example:

Google One subscription cost US citizen 6 USD / month
at 1 USD = 80 RS `price`, it should cost `480INR`/ month
but google one subscription is PPP adjusted that's why 
USD * purchasing power parity of India = same affordibility in India/ price it should be in India
6 x 23 = 138 rs/month

And guess what, price in India is 130 rs / month

Let's go by another example:
netflix:

Basic plan In USA = 9.9 USD
In india, it is 199 rs per month
[ about 9.9 * 23 ]

So these businesses are having pricing as per purchasing power parity 

Now let's take example of businesses with `not` having 

1. Leetcode subscription [ In USD, not PPP adjusted ] https://leetcode.com/subscribe/?ref=nb_npl&source=nav-shop-premium 
2. Interviewcake Subscription [ https://www.interviewcake.com/upgrade ] 

That's potential of this idea

# Now technical aspect:
This library is deployed. you can freely use it 
[android] 
Steps to integrate SDK to your android application:
1. get API_KEY from p-pe developer application [link][https://drive.google.com/file/d/13ZdVz2mlelhc3v2XWSXYvnMN-xUI3QIF/view?usp=sharing]
2. do followings steps to add p-pe to your project.


```
Take Internet permission from Manifest

Add it in your root build.gradle at the end of repositories:
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Add following dependency to your project
```
	dependencies {
	        implementation 'com.github.thehealer15:p-pe:1.0'
	}
```
At your payment activity:
Create Checkout object. 
```
Checkout obj = new Checkout(getApplicationContext() ,15F, "IND" ,"USA" ,"2oiMDOgSyDNLyUtYyZdP9MLpEC72","Gavali Associates");
obj.openPaymentModes();
// DONE!
```
NOTE : Use 3 letters; abbrivatinos only e.g IND, USA, CAD for canada, 


** ALL 	RELEVENT LINKS **
1. WIX landing page for project : [link][https://akshupatil665.wixsite.com/ppedev]
2. Youtube video explaining project : [link][https://www.youtube.com/watch?v=M4jvXIYRXRw]
3. WIX blog explaining project : [link][https://akshupatil665.wixsite.com/ppedev/post/___hi]
4. p-dev repo : [link][https://github.com/thehealer15/p-pe_dev]
5. p-pe repo : [link][https://github.com/thehealer15/p-pe#now-technical-aspect]
6. App to test : [link][https://drive.google.com/file/d/13DjeYZEoKLdP_uDBTrnBZYF8smiXx1h9/view?usp=sharing]
7. folder with relevent files, do read the `TESTING INSTRUCTIONS` file [link][https://drive.google.com/drive/folders/1QkoTDVPYySdrq1IqU_T6N_fnd0cyswAJ?usp=sharing] 



What I used:
1. Android 
2. Twilio API
3. Firebase
4. Wix

Created and curated by Akshay Pawar with ❤️ from India. 
