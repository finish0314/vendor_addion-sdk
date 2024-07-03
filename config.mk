# Parasite Signatures
$(call inherit-product-if-exists, vendor/parasite/signatures/config.mk)

# Parasite Prebuilts
$(call inherit-product-if-exists, vendor/parasite/prebuilts/config.mk)

# GMS
$(call inherit-product, vendor/google/gms/products/gms.mk)

# Microsoft
$(call inherit-product-if-exists, vendor/microsoft/mms/products/mms.mk)
