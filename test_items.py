import time
from selenium.common.exceptions import NoSuchElementException

def test_add_to_basket_button(browser):
    try:
        browser.get("http://selenium1py.pythonanywhere.com/catalogue/coders-at-work_207/")
        time.sleep(30) 
        button = browser.find_elements_by_xpath('//*[@id="add_to_basket_form"]/button')
    finally:
        assert button, "no button"
