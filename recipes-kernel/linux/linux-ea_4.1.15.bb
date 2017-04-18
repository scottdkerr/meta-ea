# Copyright (C) 2016 Embedded Artists AB
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux Kernel provided by Embedded Artists but based on NXP's kernel"
DESCRIPTION = "Linux Kernel for Embedded Artists i.MX based COM boards. \
The kernel is based on the kernel provided by NXP."

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

SRC_URI = "git://github.com/embeddedartists/linux-imx.git;protocol=git;branch=${SRCBRANCH} \
           file://defconfig"

LOCALVERSION = "-1.2.0"
SRCBRANCH = "ea_imx_4.1.15_1.0.0"
SRCREV = "426b9202dc68803f5e2f5babfea106f75771eef2"
DEPENDS += "lzop-native bc-native"


DEFAULT_PREFERENCE = "1"

#addtask copy_defconfig after do_unpack before do_configure
#do_copy_defconfig () {
#    # copy latest imx_v7_defconfig to use
#    cp ${S}/arch/arm/configs/imx_v7_defconfig ${B}/.config
#    cp ${S}/arch/arm/configs/imx_v7_defconfig ${B}/../defconfig
#}

COMPATIBLE_MACHINE = "(mx6|mx6ul|mx7)"

