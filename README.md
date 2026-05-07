**********************************************************************
step1-
vault server -config=vault-config.hcl
***********
IN NEW CMD

step2-
set VAULT_ADDR=http://127.0.0.1:8200

Step3- Initialize Vault
**********************
vault operator init

********************************************************************************************
AFTER ABOVE STEP WE WILL GET 5 UNSEAL KEYS AND ROOT TOKEN THIS WE NEED TO SAVE IN THE FILE 
********************************************************************************************
we get 5 --
*********
Unseal Key 1: +lQOv4YChlnMzB2vVWVCtvf+aZK+h88mHSDKWuNwUA1P
Unseal Key 2: D9WqNw87Rh0ups4yOHw36RD/0G6p34GOllA8sHZszH5z
Unseal Key 3: RdgiBVNIm3fb0FBIdsQqpXPkPtWPrMSsQh9Bb49whikp
Unseal Key 4: 8cLKf+4ACdWcOnQGAco5bPVTH4wDQW4fYmoKljkqLbIe
Unseal Key 5: kDpDRO26UN+YUBvg8vXxwnPhCsHzlzvfY/8fOmLusXKq

Initial Root Token: hvs.qHnzAb1F7TMWk9f8HVQWWxWF

Next step-Use any 3 out of the 5 Unseal Keys:
********************************************
   vault operator unseal <Unseal Key 1>
   vault operator unseal <Unseal Key 2>
   vault operator unseal <Unseal Key 3>

vault login <your-root-token>

vault secrets enable -path=secret kv

vault kv put secret/NAME

vault kv get secret/NAME


*****************************************************************************************
AFTER CLOSEING THE VAULT AGAIN WE NEED TO OPEN THE VAULT NEED FOLLOW THIS STEPS ?
STEPS*****
step1-
vault server -config=vault-config.hcl
IN NEW CMD
step2-
set VAULT_ADDR=http://127.0.0.1:8200
***********************************************************************************************************
STEP3-THIS STEP The Unseal Keys and the Root Token are only shown once — during the initialization of Vault THEN WE NEED TO SAVE THE Unseal Keys and the Root Token 
-->NOW WE HAVE USE THOSE Unseal Keys 
***********************************************************************************************************
   vault operator unseal <Unseal Key 1>
   vault operator unseal <Unseal Key 2>
   vault operator unseal <Unseal Key 3>
STEP4
vault login <your-root-token> 
