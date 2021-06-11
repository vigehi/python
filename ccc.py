def computepay(h,r):
    if h > 40:
        p = 1.5*r*(h - 40) + (40 * r)
        return p
    else:
        p = h * r
        return p
hrs = input("Enter Hours:")
h = float(hrs)
rate = input("enter rate per hour:")
r = float(rate)
p = computepay(h,r)
print("Pay",p)